# hash-service

A trivial example of a [Finatra](https://twitter.github.io/finatra/) service.

## Usage

    $ sbt run

And then:

    $ curl 'localhost:8888/algorithms'
    md5, sha1, sha256

    $ curl 'localhost:8888/md5/test'
    md5(test) = 098f6bcd4621d373cade4e832627b4f6

    $ curl 'localhost:8888/sha-1/test'
    sha1(test) = a94a8fe5ccb19ba61c4c0873d391e987982fbbd3

    $ curl 'localhost:8888/sha-256/test'
    sha256(test) = 9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08

    $ curl 'localhost:8888/sha-512/test'
    unsupported algorithm: sha512


## License

[MIT License](LICENSE.txt)
