package sample

import cats.effect.ExitCode
import org.http4s.dsl.Http4sDsl
import org.http4s.server.Router
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.syntax.KleisliSyntax
import zio.interop.CatsInstances
import zio.interop.catz.CatsApp
import zio.interop.catz.implicits.ioTimer
import zio.{Task, ZEnv, ZIO}

object Main extends CatsInstances with CatsApp with Http4sDsl[Task] with KleisliSyntax {

  override def run(args: List[String]): ZIO[ZEnv, Nothing, Int] = {
    val httpRoutes = Router[Task](
      "/" -> Routes.healthCheckRoutes
    ).orNotFound

    BlazeServerBuilder[Task]
      .bindHttp(9000, "0.0.0.0")
      .withHttpApp(httpRoutes)
      .serve
      .compile[Task, Task, ExitCode]
      .drain
      .fold(_ => 1, _ => 0)
  }
}
