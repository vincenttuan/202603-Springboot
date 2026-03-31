// 陣列
import './App.css'

function App() {
    const items1 = ['Apple', 'Banana', 'Orange'];
    
    // 利用 JSX 來渲染陣列
    const items2 = [
        <li key='0'>Apple</li>,
        <li key='1'>Banana</li>,
        <li key='2'>Orange</li>
    ];

    // 使用 map 來渲染 items1
    const items3 = items1.map((item, index) => {
        return (
            <>
                <li key={index}>{index}.{item}</li>
            </>
        )
    })

    // 精簡寫法
    const items4 = items1.map((item, index) => (<li key={index}>{index}.{item}</li>));


    return (
        <>
            {items1}
            {items2}
            {items3}
            {items4}
        </>
    )
}

export default App
