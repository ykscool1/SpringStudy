package Controller.CommentBoard;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO.CommentBoardDAO;
import Model.DTO.CommentBoardDTO;

public class CommentModifyProAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CommentBoardDTO dto = new CommentBoardDTO();
		
		dto.setBoardNum(Integer.parseInt(request.getParameter("BOARD_NUM")));
		dto.setBoardSubject(request.getParameter("BOARD_SUBJECT"));
		dto.setBoardContent(request.getParameter("BOARD_CONTENT"));
		dto.setBoardPass(request.getParameter("BOARD_PASS"));
		
		CommentBoardDAO dao = new CommentBoardDAO();
		dao.commentModify(dto);
		
		
	}
}
