//> using scala "3.3.1"
//> using lib "com.lihaoyi::cask:0.8.3"
//> using lib "com.lihaoyi::scalatags:0.12.0"
/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * OpenAPI spec version: 1.0.0
 *
 * Contact: team@openapitools.org
 *
 * NOTE: This class is auto generated by OpenAPI Generator.
 *
 * https://openapi-generator.tech
 */


// this is generated from apiRoutes.mustache
package sample.cask.api

import sample.cask.model.*

import upickle.default.{ReadWriter => RW, macroRW}
import upickle.default.*

import sample.cask.model.Order

class StoreRoutes(service : StoreService) extends cask.Routes {


        /** Delete purchase order by ID
         * 
         */
        @cask.delete("/store/order/:orderId")
        def deleteOrder(orderId : String, request: cask.Request) = {

        def failFast = request.queryParams.keySet.contains("failFast")

        val result =         for {
            orderId <- Parsed(orderId)
            result <- Parsed.eval(service.deleteOrder(orderId))
        } yield result

        result match {
          case Left(error) => cask.Response(error, 500)
            case Right(_) => cask.Response("", 200)
        }
      }
        /** Returns pet inventories by status
         * 
         */
        @cask.get("/store/inventory")
        def getInventory(request: cask.Request) = {
            // auth method api_key : apiKey, keyParamName: api_key

        def failFast = request.queryParams.keySet.contains("failFast")

        val result =         for {
            result <- Parsed.eval(service.getInventory())
        } yield result

        result match {
          case Left(error) => cask.Response(error, 500)
            case Right(_) => cask.Response("", 200)
        }
      }
        /** Find purchase order by ID
         * 
         */
        @cask.get("/store/order/:orderId")
        def getOrderById(orderId : Long, request: cask.Request) = {

        def failFast = request.queryParams.keySet.contains("failFast")

        val result =         for {
            orderId <- Parsed(orderId)
            result <- Parsed.eval(service.getOrderById(orderId))
        } yield result

        result match {
          case Left(error) => cask.Response(error, 500)
            case Right(_) => cask.Response("", 200)
        }
      }
        /** Place an order for a pet
         * 
         */
        @cask.post("/store/order")
        def placeOrder(request: cask.Request) = {

        def failFast = request.queryParams.keySet.contains("failFast")

        val result =         for {
              orderData <- Parsed.eval(OrderData.fromJsonString(request.bodyAsString)).mapError(e => s"Error parsing json as Order from >${request.bodyAsString}< : ${e}") /* not array or map */
              order <- Parsed.fromTry(orderData.validated(failFast))
            result <- Parsed.eval(service.placeOrder(order))
        } yield result

        result match {
          case Left(error) => cask.Response(error, 500)
            case Right(_) => cask.Response("", 200)
        }
      }

    initialize()
}
