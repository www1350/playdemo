package models

import play.api.data._
import play.api.data.Forms._
import play.api.data.format.Formats._

/**
  * Created by Administrator on 2016/9/6.
  */
case class Message(title:String,content:String)

object Message{

  var list:List[Message] = Nil
  def post(title:String, content: String) =list::=Message(title,content)
val form = Form(tuple(
       "title" -> nonEmptyText,
       "content" -> nonEmptyText
       ))

}
