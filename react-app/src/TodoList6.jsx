// TodoList 練習 6
// 利用 todos.filter 來過濾不需要的資料
import './App.css'
import { useState } from 'react'

function App () {

    const [todos, setTodos] = useState([
        {id:1, text:'吃早餐', completed:true},
        {id:2, text:'做體操', completed:false},
        {id:3, text:'寫程式', completed:false},
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
        const newTodo = {id:newId, text:todo, completed:false};
        setTodos([...todos, newTodo]);
        setTodo('');
    }

    const toggleCompletion = (id) => {
        // 透過 setTodos 來變更 todos 的 completed 資料
        // {id:1, text:'吃早餐', completed:true}
        setTodos(
            todos.map((todo) => todo.id === id ? {...todo, completed: !todo.completed} : todo )
        );
    }

    const handleTodoDelete = (id) => {
        // 利用 todos.filter 來過濾不需要的資料
        setTodos(todos.filter((todo) => todo.id !== id));
    }

    return (
        <>
            <h1>My TodoList 6</h1>
            <div>
                <input type='text' value={todo} onChange={handleTodoChange} />
                <button onClick={handleTodoAdd}>加入</button>
            </div>
            <ul>
                {
                    todos.map((todo) => (
                        <li key={todo.id} style={{textDecoration: todo.completed ? 'line-through' : 'none'}}>
                            {todo.id} - {todo.text}
                            <input type="checkbox" checked={todo.completed} onChange={() => toggleCompletion(todo.id)} />
                            {!todo.completed &&
                                (<button onClick={() => handleTodoDelete(todo.id)}>X</button>)
                            }

                        </li>
                    ))    
                }
            </ul>
        </>
    )
}

export default App