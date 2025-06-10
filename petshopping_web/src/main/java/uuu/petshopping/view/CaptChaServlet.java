package uuu.petshopping.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * Servlet implementation class CaptChaServlet
 */
@WebServlet("/captCha")
public class CaptChaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int len = 6, height = 75, width = 160;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CaptChaServlet() {
		super();
		System.out.println("CaptchaServlet 建立了一個物件");
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1.不須取得request中的FormData
		// 2.用亂數產生len個英(大小寫)數字的字元
		String captcha = "";
		Random random = new Random();
		for (int i = 0; i < len; i++){
			int data = random.nextInt(62);
			captcha = captcha + (char) (data < 10 ? data + 48 : (data < 36 ? data + 55 : data + 61));
		}
		// System.out.printf("captha: %s\n", captcha);
		HttpSession session = request.getSession();
		session.setAttribute("captCha", captcha);
		BufferedImage image = generateImage(captcha, width, height); // 繪製圖片(Draw image)
		response.setContentType("image/png");
		try (ServletOutputStream outStream = response.getOutputStream();){ // 將影像輸出到前端
			ImageIO.write(image, "PNG", outStream);
		}
	}
	private BufferedImage generateImage(String captcha, int width, int height) {
		// 開始建立圖片
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics(); // 取得影像繪圖區 //物件 g 是畫筆的觀念
		// 畫出背景方塊
		g.setColor(getRandomColor(200, 250)); // 設定繪圖區背景色 //200~250 之間取亂數, 讓螢幕顏色偏淺
		g.fillRect(0, 0, width, height); // 在繪圖區畫個長方型, 填滿背景色
		Random random = new Random();// 畫干擾線讓背景雜亂
		for (int i = 0; i < 155; i++){
			g.setColor(getRandomColor(120, 210));
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(30);
			int yl = random.nextInt(30);
			g.drawLine(x, y, x + xl, y + yl);
		}
		// 畫出認證文字
		g.setFont(new Font("Arial", Font.PLAIN, 30));// 設定字體
		g.setColor(getRandomColor(20, 140)); // 用更深的顏色來畫出
		// 將認證文字畫到image中
		g.drawString(captcha, 30, 40); // 將文字畫到中間
		g.dispose(); // 將畫筆關閉
		return image; // 這個return 不是傳到前端
	}
	private Color getRandomColor(int fc, int bc) {
		// 在參數設定的範圍內,隨機產生顏色
		Random random = new Random();
		if(fc > 255) fc = 255;
		if(bc > 255) bc = 255;
		int r = fc + random.nextInt(bc - fc);
		int g = fc + random.nextInt(bc - fc);
		int b = fc + random.nextInt(bc - fc);
		return new Color(r, g, b);
	}
}
