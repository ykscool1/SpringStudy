package Controller.CommentBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.CommentBoardDAO;
import Model.DTO.CommentBoardDTO;

public class CommentModifyAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		Integer boardNum = Integer.parseInt(request.getParameter("num"));
		CommentBoardDAO dao = new CommentBoardDAO();
		CommentBoardDTO dto = dao.oneSelect(boardNum);
		request.setAttribute("modify", dto);
	}

}
