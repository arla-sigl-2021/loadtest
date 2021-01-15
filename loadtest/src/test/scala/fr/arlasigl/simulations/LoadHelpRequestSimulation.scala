package fr.arlasigl.simulations

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.core.structure.ScenarioBuilder
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder
import io.gatling.jdbc.Predef._

class LoadHelpRequestSimulation extends Simulation {

  val frontend_url = "https://web.groupe11.kube.arla-sigl.fr"
  val backend_url = "https://api.groupe11.kube.arla-sigl.fr"

  //val frontend_url = "https://ci.groupe11.arla-sigl.fr"
  //val backend_url = "https://ci.api.groupe11.arla-sigl.fr"

  val httpProtocol: HttpProtocolBuilder = http
    .baseUrl(frontend_url)
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-us")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.2 Safari/605.1.15")

  val get_html_headers = Map(
    "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
  )

  val origin_header = Map(
    "Origin" -> frontend_url
  )

  val scn: ScenarioBuilder = scenario("LoadHelpRequestSimulation")
    .exec(http("get Arlaide HTML pages")
      .get("/")
      .headers(get_html_headers)
      .resources(http("get Arlaide javascript code")
        .get("/app.js")
        .headers(origin_header)))
    .pause(6)
    .exec(http("get help request page")
      .get(s"${backend_url}/v1/help-request?page=1&limit=10")
      .headers(origin_header)
      .resources(http("get help request comments 1")
        .get(s"${backend_url}/v1/comment?helpRequestId=3")
        .headers(origin_header),
        http("get help request comments 2")
          .get(s"${backend_url}/v1/comment?helpRequestId=4")
          .headers(origin_header),
        http("get help request comments 3")
          .get(s"${backend_url}/v1/comment?helpRequestId=5")
          .headers(origin_header),
        http("get help request comments 4")
          .get(s"${backend_url}/v1/comment?helpRequestId=2")
          .headers(origin_header),
        http("get help request comments 5")
          .get(s"${backend_url}/v1/comment?helpRequestId=6")
          .headers(origin_header),
        http("get help request comments 6")
          .get(s"${backend_url}/v1/comment?helpRequestId=7")
          .headers(origin_header),
        http("get help request comments 7")
          .get(s"${backend_url}/v1/comment?helpRequestId=8")
          .headers(origin_header),
        http("get help request comments 8")
          .get(s"${backend_url}/v1/comment?helpRequestId=5349")
          .headers(origin_header),
        http("get help request comments 9")
          .get(s"${backend_url}/v1/comment?helpRequestId=9")
          .headers(origin_header),
        http("get help request comments 10")
          .get(s"${backend_url}/v1/comment?helpRequestId=14992")
          .headers(origin_header)))

  setUp(scn.inject(constantConcurrentUsers(30).during(2.minutes))).protocols(httpProtocol)
}