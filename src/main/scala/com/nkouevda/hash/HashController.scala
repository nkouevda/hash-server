package com.nkouevda.hash

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import java.security.MessageDigest

object HashController extends Controller {

  val hashers: Map[String, MessageDigest] = Map(
    "md5" -> MessageDigest.getInstance("MD5"),
    "sha1" -> MessageDigest.getInstance("SHA-1"),
    "sha256" -> MessageDigest.getInstance("SHA-256"),
  )

  get("/algorithms") { request: Request =>
    response.ok(hashers.keys.mkString(", "))
  }

  get("/:algorithm/:input") { request: Request =>
    // Remove "-", and lowercase, so that e.g. "SHA-256" works too
    val algorithm = request.getParam("algorithm").replace("-", "").toLowerCase

    hashers.get(algorithm) match {
      case Some(hasher) =>
        val input = request.getParam("input")
        val output = toHex(hasher.digest(input.getBytes))
        response.ok(s"$algorithm($input) = $output")
      case None =>
        response.badRequest(s"unsupported algorithm: $algorithm")
    }
  }

  def toHex(bytes: Array[Byte]): String = {
    bytes.map { byte => f"$byte%02x" }.mkString
  }
}
