package fr.arlasigl.simulations

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseUrl("http://arlaide.loc:8080")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-us")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.2 Safari/605.1.15")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8",
		"If-Modified-Since" -> "Sun, 10 Jan 2021 08:57:35 GMT",
		"If-None-Match" -> """"5ffac17f-14f"""",
		"Proxy-Connection" -> "keep-alive",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"If-Modified-Since" -> "Sun, 10 Jan 2021 08:57:35 GMT",
		"If-None-Match" -> """"5ffac17f-2b3960"""",
		"Proxy-Connection" -> "keep-alive")

	val headers_2 = Map(
		"If-None-Match" -> """W/"6486-qqeHk2aAXnCFuqJm9M/LSdmLS0A"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

	val headers_3 = Map(
		"If-None-Match" -> """W/"7d8-8zFz4eKulcQnB40im/cbSk7+Ahw"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

	val headers_4 = Map(
		"If-None-Match" -> """W/"f4-Y74whc2iLgrLndP+TVSrIk9fqd8"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

	val headers_5 = Map(
		"If-None-Match" -> """W/"111-A8MutUDJAPyLGpLFTp/IsURxPho"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

	val headers_6 = Map(
		"If-None-Match" -> """W/"320-i9LUJNG2o28+fMviJ3CZobaQVcU"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

	val headers_7 = Map(
		"If-None-Match" -> """W/"100-BJmrBoIeq5kONASGrMO5J3lgaoQ"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

	val headers_8 = Map(
		"If-None-Match" -> """W/"60f-p+Y418GODW1e8cwg16HI2tTkp3w"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

	val headers_9 = Map(
		"If-None-Match" -> """W/"3f0-U1hsh06q+raUCpq4X+Fu8Wm36DU"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

	val headers_10 = Map(
		"If-None-Match" -> """W/"65a-pydtA9IHe2c+fdEagm6gi+JOAnc"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

	val headers_11 = Map(
		"If-None-Match" -> """W/"532-iOQ7DYkdlZsSw1OZXxuG1+MHzgg"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

	val headers_12 = Map(
		"If-None-Match" -> """W/"4ab-IA2oh0qpS47LqUDB04lEQauy7fo"""",
		"Origin" -> "http://arlaide.loc:8080",
		"Proxy-Connection" -> "keep-alive")

    val uri1 = "arlaide.loc"

	val scn = scenario("RecordedSimulation")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/app.js")
			.headers(headers_1)))
		.pause(6)
		.exec(http("request_2")
			.get("http://" + uri1 + ":3000/v1/help-request?page=1&limit=10")
			.headers(headers_2)
			.resources(http("request_3")
			.get("http://" + uri1 + ":3000/v1/comment?helpRequestId=3")
			.headers(headers_3),
            http("request_4")
			.get("http://" + uri1 + ":3000/v1/comment?helpRequestId=4")
			.headers(headers_4),
            http("request_5")
			.get("http://" + uri1 + ":3000/v1/comment?helpRequestId=5")
			.headers(headers_5),
            http("request_6")
			.get("http://" + uri1 + ":3000/v1/comment?helpRequestId=2")
			.headers(headers_6),
            http("request_7")
			.get("http://" + uri1 + ":3000/v1/comment?helpRequestId=6")
			.headers(headers_7),
            http("request_8")
			.get("http://" + uri1 + ":3000/v1/comment?helpRequestId=7")
			.headers(headers_8),
            http("request_9")
			.get("http://" + uri1 + ":3000/v1/comment?helpRequestId=8")
			.headers(headers_9),
            http("request_10")
			.get("http://" + uri1 + ":3000/v1/comment?helpRequestId=5349")
			.headers(headers_10),
            http("request_11")
			.get("http://" + uri1 + ":3000/v1/comment?helpRequestId=9")
			.headers(headers_11),
            http("request_12")
			.get("http://" + uri1 + ":3000/v1/comment?helpRequestId=14992")
			.headers(headers_12)))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}