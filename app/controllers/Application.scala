package controllers

import javax.inject.Inject

import models.Message
import play.api.i18n.{I18nSupport, MessagesApi}
import play.api.mvc._

class Application @Inject()(val messagesApi: MessagesApi) extends Controller with I18nSupport{

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def msgboard = Action {
    Ok(views.html.msgboard(Message.list,Message.form))
  }

  def postMsg = Action {
    implicit request =>
      Message.form.bindFromRequest.fold(
        //处理错误
        errors => BadRequest(views.html.msgboard(Message.list, errors)),
        {
          case (title, content) =>
            //发言
            Message.post(title, content)
            //重新定向到显示留言列表和发言表单页面
            Redirect(routes.Application.msgboard())
        }
      )
  }

}