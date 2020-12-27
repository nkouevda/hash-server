package com.nkouevda.hash

import com.twitter.finatra.http.HttpServer
import com.twitter.finatra.http.routing.HttpRouter

object HashMain extends HttpServer {

  override def configureHttp(router: HttpRouter): Unit = {
    router.add(HashController)
  }
}
