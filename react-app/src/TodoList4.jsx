// TodoList 練習 4
import './App.css'
import { useState } from 'react'

function App () {

    const [todos, setTodos] = useState([
        {id:1, text:'吃早餐'},
        {id:2, text:'做體操'},
        {id:3, text:'寫程式'},
    ])
    const [todo, setTodo] = useState('')

    // 變更 todo 資料
    const handleTodoChange = (e) => {
        setTodo(e.target.value);
    }

    // 加入 todo 到 todos
    const handleTodoAdd = (e) => {
        //const newId = todos.length > 0 ? todos.length + 1 : 1;
        // 在 todos 中找到最大值後 + 1
        const newId = todos.length > 0 ? Math.max(...todos.map((t) => t.id)) + 1 : 1;
        const newTodo = {id:newId, text:todo};
        setTodos([...todos, newTodo]);
        setTodo('');
    }

    return (
        <>
            <h1>My TodoList 4</h1>
            <div>
                <input type='text' value={todo} onChange={handleTodoChange} />
                <button onClick={handleTodoAdd}>加入</button>
            </div>
            <ul>
                {
                    todos.map((todo) => (
                        <li key={todo.id}>{todo.id} - {todo.text}</li>
                    ))    
                }
            </ul>
        </>
    )
}

export default App