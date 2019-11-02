package sample


import org.http4s.HttpRoutes
import org.http4s.dsl.Http4sDsl
import zio.Task
import zio.interop.CatsInstances

object Routes extends CatsInstances with Http4sDsl[Task] {

  def healthCheckRoutes: HttpRoutes[Task] = {
    HttpRoutes.of[Task] {
      case GET -> Root / "health_check" =>
        Ok("Oke")
    }

  }

}
