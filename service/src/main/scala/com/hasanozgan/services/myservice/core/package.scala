package com.hasanozgan.services.myservice

import spray.http.Uri
import spray.routing.Rejection

/**
 * Created by hozgan on 06/08/15.
 */
package object core {
  case class SecurePageRejection(uri: Uri) extends Rejection
}
