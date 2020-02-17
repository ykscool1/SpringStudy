package Controller.CommentBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.CommentBoardDAO;

public class CommentDeleteAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Integer boardNum = Integer.parseInt(request.getParameter("num"));
		
		CommentBoardDAO dao = new CommentBoardDAO();
		dao.commentDelete(boardNum);
	}
}
