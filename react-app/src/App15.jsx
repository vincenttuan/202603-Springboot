// useState 與事件處理 + 展開運算子(...)
import { useState } from "react"
import './App.css'

function App() {
    const [text, setText] = useState('')

    const handleInputChange = (e) => {
        // e.target.value 是 input 欄位的內容
        const newText = e.target.value;
        setText(newText);
        console.log(newText);
    }

    return (
        <>
            <h1>留言板</h1>
            <input type='text' value={text} onChange={handleInputChange} />
            <button>Send</button>
            <p />
            <ul>
        
            </ul>
        </>
    )
}

export default App