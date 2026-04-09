import '../App.css';

import { useState,  useEffect } from 'react';

const API_URL = 'http://localhost:8080/book'; // 後台 API

function App() {

    const [books, setBooks] = useState([]); // 書籍列表資料

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

    return (
        <>
            <h2>📚 書籍管理系統(使用 fetch)</h2>

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