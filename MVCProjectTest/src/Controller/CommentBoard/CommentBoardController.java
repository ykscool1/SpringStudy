package Controller.CommentBoard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommentBoardController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		
		if(command.equals("/CommentBoard.cb")) {
			CommentListAction action = new CommentListAction();
			action.execute(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CommentReply/comment_board_list.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/CommentWrite.cb")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("CommentReply/comment_board_write.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/CommentWritePro.cb")) {
			CommentWriteProAction action = new CommentWriteProAction();
			action.execute(request,response);
			response.sendRedirect("Comment.cb");
		
		}else if(command.equals("/CommentDetailAction.cb")) {
			CommentDetailAction action = new CommentDetailAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CommentReply/comment_board_view.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/CommentModify.cb")) {
			CommentModifyAction action = new CommentModifyAction();
			action.execute(request,response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CommentReply/comment_board_modify.jsp");
			dispatcher.forward(request, response);
		
		}else if(command.equals("/CommentModifyAction.cb")) {
			CommentModifyProAction action = new CommentModifyProAction();
			action.execute(request,response);
			response.sendRedirect("CommentDetailAction.cb?num="+request.getParameter("BOARD_NUM"));
		
		}else if(command.equals("/CommentDelete.cb")) {
			CommentDeleteAction action = new CommentDeleteAction();
			action.execute(request,response);
			response.sendRedirect("Comment.cb");
		}
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req,resp);
	}
}
