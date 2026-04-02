// 使用 useState (Hook)
// 建立一個"會記住值的變數" + "改變他的方法"
import { useState } from "react"
import './App.css'

// 組件
function App() {
    const [count, setCount] = useState(0);

    // 方法
    function handleClick() {
        setCount(count + 1);
        console.log(count);
    }

    return (
        <>
            <div>{count}</div>
            <button onClick={handleClick}>按我一下 + 1</button>
        </>
    )
}

export default App