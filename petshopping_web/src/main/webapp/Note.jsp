<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
	</head>
	<body>
	<p> 
		瀏覽器上，首頁不能把名子打出來，只能讓客戶看到網址，不能看到首頁的檔名 
	</p>
	<p>href沒有打網址(空字串)，按下去後等於原頁面更新</p>
	<p>
		所以要回到首頁的href屬性的值輸入"./" 就是現在路徑的意思
	</p>
	<p>
		最左邊不是斜線就是相對路徑
	</p>
	<p>
		std.tag ->指有頭有尾的標籤   void tag -> 指只有頭不需要尾巴的標籤，例如<br>
	</p>
	<p>
		div是單純block元素效果，但是沒有行距效果，p元素才有行距效果
	</p>
	<p>
		為什麼margin: auto;沒有置中效果??? 因為元素的預設寬度為螢幕全寬，這時候選margin: auto;不會有效果
	</p>
	<p>
		用ipconfig命令去查詢IPv4 位址，網址的前方要加上http://        http:// + IPv4 Address
	</p>
	<p>
		輸入元件有5種:   input, select, textarea, button, color
	</p>
	<p>
		void tag element
	</p>
	<p>
		觀看前端網頁輸入的投送值:  F12 -> Network -> All -> Name -> Payload
	</p>
	<p>
		EJB Enterprise JavaBean
	</p>
	<p>
		登入帳號有好多class要寫判定標準，我們可以將判定標準統一寫在JSP，然後命令所有人照這份JSP定義的標準去做檢查
	</p>
	<p>
		lib 跟 web 兩個前後端專案如何串接起來????
	</p>
	<p>
		要記錄下安裝伺服器所使用的portNumber，不然以後安裝其他伺服器，會出現portNumber衝突
	</p>
	<p>
		安裝伺服器不可以在eclipse以外環境啟動，只能安裝，然後到eclipse操作(開發人員的環境在eclipse啟動)
	</p>
	<p>
		一定要先安裝好伺服器，才可以在eclipse建立Dynamic Web Project
	</p>
	<p>
		切換到新的workspace等於eclipse恢復原廠設定
	</p>
	<p>
		伺服器會優先判定index.html或 index.jsp作為網站首頁
	</p>
		http通訊協定，設定成封包傳送接收完成後馬上中斷連線，目的是避免佔用資源，避免佔線   (話務兵講完話要講over，然後等對方回話，再按下通話鈕繼續講訊息出去)
	<P>
		要特別為了404頁面設計，不能讓外界看到原先404，不然伺服器資訊會外露
	</P>
	<P>
		每一個網路封包分成三段:  Request: commend line (Get, Post, Put(put功能已經被封印了)) -> headers(cookie放在這裡) -> body  
						   Post請求才會出現在第三段(body)，Get請求沒有第三段(body)
	</P>
	<P>
											Response: status line -> headers(cookie放在這裡) -> body
	</P>
	<P>
		java 的字碼是反斜線開頭(\)，網站上的字碼是百分比開頭(%)
	</P>	
		<form>元素內的submit才能做出post請求</form>	
	<P>
		登入跟註冊一律使用post method, 查詢的功能才使用get method 
	</P>
	<P>
		http通訊協定可以半路被攔截監聽，https才有加密，半路攔截也無法解密
	</P>
	<P>
		適當拖延瀏覽器更新的秒數，有利於伺服器效能的優化
	</P>
	<P>
		java的LoginServlet類別，是伺服器廠商編寫好的父類別(用來使彼此符合http通訊協定)，讓網站開發者的java可以讀取到html的請求，
		我們繼承Servlet父類別，來改寫成符合需求的子類別
	</P>
	<P>
		Servlet是指可以在伺服器上操作的小小元件  用HttpFilter.class來看得懂html的請求和回應
	</P>
	<P>
		servlet類別不能寫在java project，要寫在Dynamic Wed project，我們不能保證server會不會變動或被取代，所以後端的java商業邏輯必須定義在java project 
	</P>
	<P>
		幫servlet設定一個假的網址，類似郵件信箱的概念，用假網址對應到servlet，servlet類別不用new()，伺服器會根據請求的網址自己new()，
		且new()過後可以不用再次new()，會利用多執行緒去應付同時多個請求
	</P>
	<P>
		登入畫面，伺服器故意不開啟doGet，這樣帳號密碼就不會出現在網址上，勾選doGet，就容易延伸出灌票程式
	</P>
	<P>
		但就算沒有勾選doGet也能灌票，只是門檻稍微高
	</P>
	<P>
		只有Web專案才有server，只有server才能有controller
	</P>
	<P>
		html不可能在server執行，html只能傳送請求與回應伺服器
	</P>
	<P>
		客戶請求送到湯姆貓伺服器，伺服器找到java Servlet class ，解讀請求封包，去對應java 元件
	</P>
	<P>
		asp 導向給jsp
	</P>
	<P>
		Ajax 是部分網頁更新的請求，所以網頁列不會變更，看不到錯誤，只能用F12看
	</P>
	<P>
		請求回應得到會應然後看到前端的畫面的同時，代表後端的程式已經結束且清除暫存記憶體
	</P>
	<P>
		把資料庫連線建立在比較高的位置，使用者建立連線後就沒有斷線，session類似會議階段的概念，(會議持續的Connection)
	</P>
	<P>
		會員登入後繼逛產品清單或加入購物車不會被登出，伺服器記憶體也沒有被清除: session功能
	</P>
	<P>
		以前圖片是非同步請求，文字檔先過去然後圖片檔再過去，除非用inbad嵌入
	</P>
	<P>
		伺服器端有規劃session記憶體，模擬連線的記憶體，實際上連線的記憶體已經斷掉，客戶端電腦與伺服器發生連線，然後把GUID或UUID送給session 
	</P>
	<P>
		然後連線的記憶體就可清除，由session記憶體去模擬連線記憶體 ，目前定義部會有同時間不同電腦產生一樣的GUID或UUID，確保客戶分離，且釐清請求來源
	</P>
	<P>
		伺服器端回應客戶的第一次請求，也同時也把session ID 放在封包的header，讓使用者電腦記著，同一個客戶下一次送出請求，
		就會帶著這個session ID去跟伺服器比對，避免客戶資料衝突
	</P>
	<P>
		其實客戶端瀏覽器也可以設定不準自己電腦儲存session，下次客戶連線就會被判定為新的連線，
		但這種清除在伺服器端沒有把記憶體清除，只是該記憶體區域不讓使用，但伺服器也有可能
		設定timeout(大多為30分鐘) 時間到會變成伺服器連線逾時，讓客戶登出，把session記憶體清除，
		但臉書系統是把session ID額外儲存在檔案內，斷線後還能用相同session ID 連線
	</P>
	<P>
		會員資料、購物車資料、驗證碼資料都是兩個請求交換資料
	</P>
	<P>
		例如CaptchaServlet產生驗證碼，會同時給客戶端，也給RegisterServlet
	</P>
	<P>
		同一個資料，有兩個請求之間要交換，就會使用到session功能
	</P>
	<P>
		session ID 是不會在使用者電腦儲存的一種cookie
	</P>
	<P>
		無痕視窗是存在不同的記憶體，所以session不會被保留
	</P>
	<P>
		內部轉交: 類似偷偷把任務轉給同事，但外面客戶看不出來 建築物有政客的落款，但建築物實際上是工程人員蓋出來的
        如果都用內部轉址，session記憶體會積累太多資料，髒髒的
	</P>
	<P>
		外部轉址: response.sendRedirect()，打電話到公司找業務，服務人員給業務的手機號碼，客戶自己打電話給業務
	</P>
	<P>
		外部轉址: 只有登入跟登出的功能在session範圍，才能用內部轉址，其餘用外部轉址(Redirect)，不然伺服器session會存太多資料，例如錯誤訊息就不應該放在Redirect
	</P>
	<P>
		如果已經登入成功，在故意進入登入畫面，應該要被強迫回到首頁，不能在讓客戶看到登入的頁面
	</P>
	<P>
		Logout, 首頁跟購物車才使用Redirect方式
	</P>
	<P>
		只要logout就把整個session殺掉
	</P>
	<p>
		第一次收到使用者的請求時，JSP就轉譯成JAVA檔案 
		JSP 轉譯成 JAVA 再編譯成位元檔 
	</p>
	<p>
<%-- 		使用<%@ include%> 是在轉譯成java的同時就將子網頁內容就併入java檔，這樣有隱含變數的功能 --%>
<!-- 		，就不要再宣告變數，避免重複宣告 子網頁宣告了變數就是隱含變數，真正母網頁不用重複宣告 -->
<!-- 		子網頁的程式碼會寄生在每一個匯入的母網頁程式碼裏頭(JSP轉譯成JAVA的時候救寄生上去(隱含變數的概念)) -->
<!-- 		有隱含變數的效果，但不能傳遞參數 -->
<!-- 		這種方式變更子網頁內容時，所有網頁的java檔要一起更改，較為耗時，比較適合不頻繁變更的子網頁內容 -->
	</p>
	<p>
<%-- 		<jsp:include>不會在轉譯成JAVA的時候子網頁就寄生 子網頁會自己單獨轉譯(變成兩個類別)，在執行時期才合併輸出html --%>
<%-- 			所以才可以有<jsp:param> 傳遞參數 所以子網頁內容變更時，重新生效到全部網頁的效率較快，此方式適合頻繁變更內容的子網頁 --%>
	</p>
	<p>
		瀏覽器只能執行三個功能:  html 帶入內容, CSS做排版, JavaScript做動態效果
	</p>
	<p>
<%-- 		JSP Action Tags <jsp:include/> --%>
	</p>
	
	<p>
		不能left 又right join 會爆掉，除了Inner Join 也要搞懂 Outer Join
	</p>
	<p>
		如何避免不同客戶看到相同庫存，然後搶同一個庫存結果要出貨給誰????
	</p>	
	<p>
		避免購物車資料遭到客戶竄改價錢或照片編號庫存等等(Read Only)	
	</p>
	<p>
		購物車頁面要能秀出客戶選購的顏色或規格照片
	</p>	
<P>
	有三個地方可以清除網頁專案的舊設定: Project > Clean,   Server的remove功能, Clean Module Work Directory, 以及瀏覽器的catch
</P>
<P>
	第一次送請求沒有經過controller，第二次才有?????
</P>
<P>
	JSP其實就是Servlet 彼此是分工關係
</P>
<P>
	不同請求用相同的資料，就使用session功能
</P>
<P>
	客戶前端可以將資料存在cookie以及localStorage
</P>


<P>
	login.jsp  -> LoginServlet -> login_ok.jsp 
</P>
<P>
	check_out.jsp -> CheckOutServlet  -> check_out.jsp
</P>
<P>
	網拍下載的特定APP，其實內容也是Web view被叫出來，只是這個APP只限定開自己企業的網頁
</P>
<P>
	Filter 其實是AOP(Aspect-oriented programming) 的實作利用 就是更上游設定什麼條件要發生什麼事
</P>
<P>
	因為一個專案有好多分頁會牽涉到編碼問題，所以把filter 獨立出來做為一個類別 
課程中我們先針對編碼問題設計filter，只要檔案是.do或者.jsp檔案，裡面的request及response的編碼都能在更上游被設定
</P>
<P>
	interceptor: 攔截請求，進行程式碼加油添醋-> 交給下游
</P>
<P>
	Get請求 編碼放網址列，網址列的編碼是UTF-8，所以程式內如果是BIG5，就會錯誤 
 但有的廠商會把所有請求改成POST請求，避免編碼跑到網址列被誤判 
</P>
<P>
	localhost自動轉成IP Address 才能有第三方的資源，例如超商
</P>
<P>
	子網頁一定要寫絕對路徑，分出去後，各網頁才能同一個基礎點去找檔案
</P>
<P>
	html中 標籤內可以自建立自己要的屬性，但屬性名稱要以data-開頭
</P>


<P>
	Master -> Detail 的Foreign Key設計
</P>
<P>
	OOAD.pdf 196頁 scenarios
</P>


<P>
	購物車使用集合物件
</P>
<P>
	資料庫的資料跟加總不能共存 跟Excel不一樣
</P>
<P>
	多對多的概念： 一個客戶可以喜歡好幾種產品，同一個產品也可以被好多客戶喜歡
</P>
<P>
	購物車的資料一定是後台資料，避免被使用者竄改，且不能讓客戶去竄改後台資料庫
</P>

<P>
		AJAX 屬於純前端
</P>
<P>
	FKey 會影響主建值的順序，所以效能好
</P>
<P>
	Set 在建立的時候即指定排序，不能在事後變更
</P>
<P>
	紀錄資料的類別: entity package -> entity class
</P>
<p>
	用TreeMap 跟 HashMap 寫購物車才是最優化方式
</p>
<p>Map物件是K,V Pair 其中 Key的部分是由Set物件所組成，Value區塊可能是Set也可能是List所構成(只能知道是Collection)，所以必須要用Iterator</p>
<p>請求中帶著Session ID 到伺服器查詢，沒有Session 才建立新的Session ID</p>
<p>表單資料沒有特別設定method，預設值會是get，沒有特別設定action，預設值會是傳給自己</p>
<p>如果資料庫是Primary Key，到了Java就是 entity 的equals, hashCode，hashCode可以理解為內部ID，java 的hashCode因為是整數格式最多只有到43億
，要不同系統有不同hashCode</p>
<p>蝦皮的系統，一個賣家會是不同的購物車(不同的hashCode)</p>
<p>進入所有member資料夾底下的網頁，都強制要求要登入，但我們偷懶不為每一個網頁都寫判斷式
，我們可以製造一個filter檔案</p>
<%-- <p>    (< %=  就是等於 ${)       (%> 就是等於})    彼此是替代關係，不能混雜用</p> --%>
<p>
	
</p>



<p>web.xml檔案設定三大鐵律:  </p>

<p>
 OdersDAO Statement.RETURN_GENERATED_KEYS 在資料庫自動給號且回傳給伺服器，不能用Select MAXIMUM() ，不然會客戶搶號
</p>
<p>一個以上的指令只定義在OdersDAO 是因為要共用同一個連線，所以只故意定義在同一個類別</p>
<p>executeBatch() 批次程式最容易被SQL_injection 竄改，所以用executeUpdate()</p>
<p>jQuery 針對selected checked 才使用.prop()</p>

<p>
Asta針對中文可能出現亂碼，解決方式是先到NotePad++設定系統編碼，再貼回Asta</p>
	</body>
</html>