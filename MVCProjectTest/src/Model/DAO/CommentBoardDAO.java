package Model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.DTO.CommentBoardDTO;

public class CommentBoardDAO extends DataBaseInfo {
	static String jdbcDriver;
	static String jdbcUrl;
	static Connection conn;
	ResultSet rs;
	PreparedStatement pstmt;
	String sql;
	String columns = "board_num,user_id,board_name,board_pass,board_subject,board_content,board_date,ip_addr,read_count";
	
	
	public void commentInsert (CommentBoardDTO dto) {
		getConnection();
		String subquery = "select nvl(max(board_num),0) + 1 from comment1";
		
		sql = "insert into comment1 (" + columns + ") values(( " + subquery + "),?,?,?,?,?,sysdate,?,0)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getUserId() );
			pstmt.setString(2,dto.getBoardName() );
			pstmt.setString(3,dto.getBoardPass() );
			pstmt.setString(4,dto.getBoardSubject());
			pstmt.setString(5,dto.getBoardContent());
			pstmt.setString(6,dto.getIpAddr() );
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	
	//"board_num,user_id,board_name,board_pass,board_subject,board_content,board_date,ip_addr,read_count"
	public List boardAllSelect() {
		List list = new ArrayList();
		getConnection();
		sql = "select " + columns + " from comment1";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CommentBoardDTO dto = new CommentBoardDTO();
				dto.setBoardNum(rs.getInt(1));
				dto.setUserId(rs.getString(2));
				dto.setBoardName(rs.getString(3));
				dto.setBoardPass(rs.getString(4));
				dto.setBoardSubject(rs.getString(5));
				dto.setBoardContent(rs.getString(6));
				dto.setBoardDate(rs.getTimestamp(7));
				dto.setIpAddr(rs.getString(8));
				dto.setReadCount(rs.getInt(9));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
		
		return list;
	}
	
	public Integer commentCount() {
		Integer result = 0;
		getConnection();
		sql = "select count(*) from comment1";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	
		return result;
	}
	
	//"board_num,user_id,board_name,board_pass,board_subject,board_content,board_date,ip_addr,read_count"
	
	public CommentBoardDTO oneSelect(Integer num) {
		CommentBoardDTO dto = new CommentBoardDTO();
		sql = "select " + columns + " from comment1 where board_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			rs.next();
			dto.setBoardNum(rs.getInt(1));
			dto.setUserId(rs.getString(2));
			dto.setBoardName(rs.getString(3));
			dto.setBoardPass(rs.getString(4));
			dto.setBoardSubject(rs.getString(5));
			dto.setBoardContent(rs.getString(6));
			dto.setBoardDate(rs.getTimestamp(7));
			dto.setIpAddr(rs.getString(8));
			dto.setReadCount(rs.getInt(9));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	
	public void commentModify(CommentBoardDTO dto) {
		getConnection();
		sql = "update comment1 set board_subject=?,board_content=? where board_pass=? and board_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getBoardSubject());
			pstmt.setString(2, dto.getBoardContent());
			pstmt.setString(3, dto.getBoardPass());
			pstmt.setInt(4, dto.getBoardNum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void boardCountUpdate(Integer num) {
		getConnection();
		
		sql = "update comment1 set read_count = read_count + 1 where board_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public void commentDelete(Integer num) {
		getConnection();
		sql = "delete from comment1 where board_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}

}
