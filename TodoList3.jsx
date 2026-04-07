// TodoList 練習 3
import './App.css'
import { useState } from 'react'

function App () {

    //const todos = ['吃早餐', '做體操', '寫程式', '玩橋牌']
    const [todos, setTodos] = useState([])
    const [todo, setTodo] = useState('')

    // 變更 todo 資料
    const handleTodoChange = (e) => {
        setTodo(e.target.value);
    }

    // 加入 todo 到 todos
    const handleTodoAdd = (e) => {
        setTodos([...todos, todo]);
        setTodo('');
    }

    return (
        <>
            <h1>My TodoList</h1>
            <div>
                <input type='text' value={todo} onChange={handleTodoChange} />
                <button onClick={handleTodoAdd}>加入</button>
            </div>
            <ul>
                {
                    todos.map((todo, index) => (
                        <li key={index}>{todo}</li>
                    ))    
                }
            </ul>
        </>
    )
}

export default App