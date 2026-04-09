import '../App.css';

import { useState,  useEffect } from 'react';

const API_URL = 'http://localhost:8080/book'; // 後台 API

function App() {

    const [books, setBooks] = useState([]); // 書籍列表資料
    //const [form, setForm] = useState({id: null, name: 'demo', price: '10', amount: '20', pub: true}); // 表單內容
    const [form, setForm] = useState({id: null, name: '', price: '', amount: '', pub: false}); // 表單內容
    const [editing, setEditing] = useState(false); // 是否為編輯(修改)模式

    // 讀取書籍資料
    const fetchBooks = async() => {
        try {
            const res = await fetch(API_URL);
            const result = await res.json();
            console.log(result);
            // 設定書籍
            setBooks(result.data || []);
        } catch(e) {
            console.error('讀取錯誤:', e);
        }
    }

    // React 將 UI 畫面渲染後要執行的工作
    // [] 在 UI 畫面渲染後只會執行一次
    useEffect(() => {
        fetchBooks();
    }, [])

    // 當表單欄位被改變, 把最新的資料存回到 form 資料中
    const handleChange = (e) => {
        const {name, value, type, checked} = e.target;
        console.log(name, value, type, checked)
        
        setForm((prev) => ({
            ...prev,
            [name]: name === 'pub' ? checked : value
        }));
    }

    // 新增
    const handleSubmit = async(e) => {
        e.preventDefault(); // 停止預設行為
        try {
            const method = editing ? 'PUT' : 'POST';
            const url = editing ? `${API_URL}/${form.id}` : API_URL;
            const res = await fetch(url, {
                method,
                headers: {'Content-type': 'application/json'},
                body: JSON.stringify(form)
            });
            const result = await res.json();
            console.log(result);
            if(res.ok) {
                fetchBooks(); // 重新查詢所有書籍
                setForm({id: null, name: '', price: '', amount: '', pub: false}) // 清空表單
            } else {
                alert(result.message || '操作失敗');
            }
        } catch(e) {
            console.error('錯誤:', e);
        }
        // 恢復到新增狀態
        setEditing(false);
    }

    // 修改功能
    const handleEdit = (book) => {
        setForm(book); // 將 book 資料填入到表單中
        setEditing(true);
    }

    // 刪除功能
    const handleDelete = async (book) => {
        if(!window.confirm(`是否要刪除 ${book.name} 這本書?`)) return;

        try {
            const res = await fetch(`${API_URL}/${book.id}`, {
                method: 'DELETE'
            });
            const result = await res.json();
            if(res.ok) {
                fetchBooks(); // 重新查詢所有書籍
            } else {
                alert(result.message || '刪除失敗');
            }
        } catch(e) {
            console.error('刪除錯誤:', err);
        }

    }

    return (
        <>
            <h2>📚 書籍管理系統(使用 fetch)</h2>
            <form onSubmit={handleSubmit}>
                書名：<input type="text" name="name" value={form.name} onChange={handleChange} required /><p />
                價格：<input type="number" name="price" value={form.price} onChange={handleChange} required /><p />
                數量：<input type="number" name="amount" value={form.amount} onChange={handleChange} required /><p />
                出刊：<input type="checkbox" name="pub" checked={form.pub}  onChange={handleChange} /><p />
                <button type="submit">{editing?'修改':'新增'}書籍</button>
                {
                    editing && (
                        <button type="button" onClick={() => {
                            setEditing(false); // 取消編輯修改模式
                            setForm({id: null, name: '', price: '', amount: '', pub: false}); // 清空表單
                        }}>取消</button>
                    )
                }
                
            </form>

            <h2>📒 書籍列表</h2>
            <table border={1} cellPadding={4}>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>書名</th>
                        <th>價格</th>
                        <th>數量</th>
                        <th>出刊</th>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        books.map((book) => (
                            <tr key={book.id}>
                                <td>{book.id}</td>
                                <td>{book.name}</td>
                                <td>{book.price}</td>
                                <td>{book.amount}</td>
                                <td>{book.pub ? '是' : '否'}</td>
                                <td>
                                    <button onClick={() => handleEdit(book)}>修改</button>
                                    <button onClick={() => handleDelete(book)} >刪除</button>
                                </td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </>
    )
}

export default App