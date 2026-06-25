// useState 是 React 的狀態管理
import { useState } from "react";

function ItemsPage() {
    // 目前先使用假資料(先不用連後端 API)
    const [items] = useState([
        {
            id: 1, name: 'A01 教室', type: '教室', location: '一樓', 
            pricePerHour: 300, status: 'AVAILABLE', 
            description: '可容納 30 人, 適合課程與會議'
        },
        {
            id: 2, name: '投影機', type: '設備', location: '器材室', 
            pricePerHour: 100, status: 'AVAILABLE', 
            description: '適合簡報與教學使用'
        },
        {
            id: 3, name: '活動場地', type: '場地', location: 'B1', 
            pricePerHour: 500, status: 'AVAILABLE', 
            description: '適合小型活動與聚會'
        }
    ]);

    return (
        <section>
            <h1>租用項目</h1>
            
            {/* 利用 grid 來排版多張卡片(租用項目) */}
            <div className="grid">
                {/* 利用 map 來走訪 items 裡的每一筆資料並轉成畫面UI標籤 */}
                {
                    items.map((item) => (
                        <article className="card" key={item.id}>
                            <h2>{item.name}</h2>
                            <p>
                                {item.type} | {item.location}
                            </p>
                            <p>
                               {item.description} 
                            </p>
                            <p className="price">
                                NT$ {item.pricePerHour} / 小時
                            </p>
                            <span className="badge">
                                {item.status}
                            </span>
                        </article>
                    ))
                }

            </div>

        </section>

    )

}

export default ItemsPage;