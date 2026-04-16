// 建立組件的二種方法
// 1. function
// 2. () => 函數式
import './App.css'

// 子組件
function Hello() {
    return (
        <h1>Hello 哈囉</h1>
    )
}

// 子組件
const World = () => {
    return (
        <h1>World 世界</h1>
    )
}

// 父組件
function App() {
    return (
        <>
            <Hello />
            <World />
        </>
    )
}

export default App