package Controller.CommentBoard;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO.CommentBoardDAO;
import Model.DTO.CommentBoardDTO;

public class CommentWriteProAction {
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		
		CommentBoardDTO dto = new CommentBoardDTO();
		dto.setUserId((String)session.getAttribute("memId"));
		dto.setBoardName(request.getParameter("BOARD_NAME"));
		dto.setBoardPass(request.getParameter("BOARD_PASS"));
		dto.setBoardSubject(request.getParameter("BOARD_SUBJECT"));
		dto.setBoardContent(request.getParameter("BOARD_CONTENT"));
		dto.setIpAddr(request.getRemoteAddr());
		CommentBoardDAO dao = new CommentBoardDAO();
		dao.commentInsert(dto);
	}
}
