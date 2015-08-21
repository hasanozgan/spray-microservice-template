package com.hasanozgan.services.myservice.httpservices

import com.hasanozgan.services.myservice.httpservices.models.User
import com.wordnik.swagger.annotations._
import spray.routing.Route

// Trying to not pollute the code with annotations
@Api(value = "/membership", description = "Operations for users.", consumes= "application/json",  produces = "application/json")
trait MembershipHttpServiceDoc {

  @ApiOperation(value = "Get a user by id", httpMethod = "POST", response = classOf[User])
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "userId", value="ID of the user that needs to retrieved", required = true, dataType = "integer", paramType = "path" )
  ))
  @ApiResponses(Array(
    new ApiResponse(code = 200, message = "Ok"),
    new ApiResponse(code = 404, message = "User not found")
  ))
  def signIn: Route

  @ApiOperation(value = "Add a new user to the system", httpMethod = "POST", consumes="application/json", response = classOf[User])
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "body", value="User object to be added", required = true, dataType = "router.UserDto", paramType = "body" )
  ))
  @ApiResponses(Array(
    new ApiResponse(code = 405, message = "Invalid user"),
    new ApiResponse(code = 201, message = "Entity Created")
  ))
  def signUp: Route

}