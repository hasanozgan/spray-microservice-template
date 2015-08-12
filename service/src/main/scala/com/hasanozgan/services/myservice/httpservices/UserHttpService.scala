package com.hasanozgan.services.myservice.httpservices

import com.wordnik.swagger.annotations._
import spray.http.MediaTypes
import spray.routing.HttpService

/**
 * Created by hozgan on 10/08/15.
 */

@Api(value = "/user", description = "Operations about users.", position=1)
trait UserHttpService extends HttpService {

  val routes = getUserByName ~ getUsers

  @ApiOperation(value = "Get user by name", notes = "", response=classOf[String], nickname = "getUserByName", httpMethod = "GET")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "username", value = "ID of pet that needs to be updated", required = true, dataType = "string", paramType = "path"),
    new ApiImplicitParam(name = "body", value = "Updated user object.", required = false, dataType = "string", paramType = "form")
  ))
  @ApiResponses(Array(
    new ApiResponse(code = 404, message = "User not found"),
    new ApiResponse(code = 400, message = "Invalid username supplied")
  ))
  def getUserByName = get { path("user" / Segment) { id => {
    complete(s"{$id}")
  }}}

  @ApiOperation(value = "Get users", notes = "", response=classOf[String], nickname = "getUsers", httpMethod = "GET")
  def getUsers = get { path("users") { respondWithMediaType(MediaTypes.`application/json`) {
    complete("users")
  }}}
}

