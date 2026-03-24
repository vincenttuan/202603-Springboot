// ========================
// 功能:
// 1.查詢全部
// 2.查詢單筆
// 3.顯示訊息
// 4.顯示表格
// ========================

// API 基本路徑
const API_BASE_URL = "/book";

// 抓取畫面元素(id)
const messageBox = document.getElementById("messageBox");
const searchId = document.getElementById("searchId");
const findOneBtn = document.getElementById("findOneBtn");
const findAllBtn = document.getElementById("findAllBtn");
const singleResult = document.getElementById("singleResult");
const bookTableBody = document.getElementById("bookTableBody");

// 綁定查詢按鈕事件
findOneBtn.addEventListener("click", findBookById);
findAllBtn.addEventListener("click", findAllBooks);

// 顯示訊息
function showMessage(message, type = "info") {
	messageBox.textContent = message;
	messageBox.className = `message-box ${type}`;
}

// 統一處理 fetch 回應
async function handleResponse(response) {
	const result = await response.json();
	
	if(!response.ok) {
		throw new Error(result.message || "發生錯誤");
	}
	
	return result;
}

// 查詢全部
async function findAllBooks() {
	try {
		const response = await fetch(API_BASE_URL);
		const result = await handleResponse(response);
		console.log(result); // debug 用
		renderBookTable(result.data); // 資料渲染到表格中
		showMessage(result.message || "查詢全部成功", "success");
	} catch(error) {
		renderBookTable([]); // 資料渲染空白資料
		showMessage(error.message, "error");
	}
}

// 查詢單筆
async function findBookById() {
	try {
		const id = searchId.value;
		
		if(!id) {
			showMessage("請輸入要查詢的書籍 ID", "error");
			return;
		}
		
		const response = await fetch(`${API_BASE_URL}/${id}`);
		const result = await handleResponse(response);
		
		console.log(result); // debug 用, 顯示 json 物件
		console.log(JSON.stringify(result)); // debug 用, 顯示 json 字串
		
		singleResult.textContent = JSON.stringify(result); 
		showMessage(result.message || "單筆查詢成功", "success");
	} catch(error) {
		singleResult.textContent = "查詢失敗";
		showMessage(error.message, "error");
	}
}

// 渲染表格
function renderBookTable(books) {
	if(!books || books.length === 0) {
		bookTableBody.innerHTML = `
			<tr>
				<td colspan="5" class="empty-now">目前沒有資料</td>
			</tr>
		`;
		return;
	}
	
	let html = "";
	books.forEach(book => {
		html += `
			<tr>
				<td>${book.id}</td>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.amount}</td>
				<td>${book.pub ? "是" : "否"}</td>
			</tr>
		`;
	});
	
	bookTableBody.innerHTML = html; 
}




