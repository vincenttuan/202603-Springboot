import '../App.css';

import { useState,  useEffect } from 'react';

const API_URL = 'http://localhost:8080/book'; // 後台 API

function App() {

    const [books, setBooks] = useState([]); // 書籍列表資料
    //const [form, setForm] = useState({id: null, name: 'demo', price: '10', amount: '20', pub: true}); // 表單內容
    const [form, setForm] = useState({id: null, name: '', price: '', amount: '', pub: false}); // 表單內容

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

    return (
        <>
            <h2>📚 書籍管理系統(使用 fetch)</h2>
            <form>
                書名：<input type="text" name="name" value={form.name} onChange={handleChange} required /><p />
                價格：<input type="number" name="price" value={form.price} onChange={handleChange} required /><p />
                數量：<input type="number" name="amount" value={form.amount} onChange={handleChange} required /><p />
                出刊：<input type="checkbox" name="pub" checked={form.pub}  onChange={handleChange} /><p />
                <button type="submit">新增書籍</button>
            </form>

            <h2>📒 書籍列表</h2>
            <table border={1} cellPadding={4}>
                <thead>
                    <tr>
                        <td>ID</td>
                        <td>書名</td>
                        <td>價格</td>
                        <td>數量</td>
                        <td>出刊</td>
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
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </>
    )
}

export default App