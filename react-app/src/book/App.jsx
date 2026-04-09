import '../App.css';

import { useState,  useEffect } from 'react';

const API_URL = 'http://localhost:8080/book'; // 後台 API

function App() {

    // 讀取書籍資料
    const fetchBooks = async() => {
        try {
            const res = await fetch(API_URL);
            const result = await res.json();
            console.log(result);
        } catch(e) {
            console.error('讀取錯誤:' + error);
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

        </>
    )
}

export default App