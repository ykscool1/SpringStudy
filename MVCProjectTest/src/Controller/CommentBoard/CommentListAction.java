package Controller.CommentBoard;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.CommentBoardDAO;

public class CommentListAction {
	public void execute (HttpServletRequest request, HttpServletResponse response) {
		List list = new ArrayList();
		CommentBoardDAO dao = new CommentBoardDAO();
		list = dao.boardAllSelect();
		Integer count = dao.commentCount();
		request.setAttribute("comment", list);
		request.setAttribute("count", count);
		
	}
}
