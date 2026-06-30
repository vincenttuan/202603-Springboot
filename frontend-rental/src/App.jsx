/**
 * 路徑:/                   模組:<ItemsPage />             租用項目
 * 路徑:/login              模組:<LoginPage />             登入項目
 * 路徑:/my-reservations    模組:<MyReservationPage />     我的預約資料
 * 路徑:/admin/items        模組:<AdminItemsPage />        租用項目管理
 * 路徑:/admin/reservations 模組:<AdminReservationsPage /> 預約審核
 * 
 * 安裝 React Router
 * 指令 npm install react-router-dom
 */

import { Route, Routes } from "react-router-dom"

// 匯入 Navbar
import Navbar from "./components/Navbar"

// 匯入 ProtectedRoute
import ProtectedRoute from "./components/ProtectedRoute"

import ItemsPage from './pages/ItemsPage'
import LoginPage from './pages/LoginPage'
import MyReservationsPage from './pages/MyReservationsPage'
import AdminItemsPage from './pages/AdminItemsPage'
import AdminReservationsPage from './pages/AdminReservationsPage'

function App() {
  return (
    <>
      {/* Navbar 放在 Routers 的外面代表每一頁都可以看得到 */}
      <Navbar />

      <main className="container">
        {/* Routes 代表路由區域 */}
        <Routes>
          {/* 首頁(租用項目) */}
          <Route path="/" element={<ItemsPage />} />
          
          {/* 登入頁 */}
          <Route path="/login" element={<LoginPage />} />

          {/* 我的預約頁: 需要登入 */}
          <Route 
            path="/my-reservations" 
            element={
              <ProtectedRoute>
                <MyReservationsPage />
              </ProtectedRoute>
            } />

          {/* 管理者-項目管理頁 */}
          <Route 
            path="/admin/items" 
            element={
              <ProtectedRoute adminOnly>
                <AdminItemsPage />
              </ProtectedRoute>
            } />

          {/* 管理者-預約審核頁 */}
          <Route 
            path="/admin/reservations" 
            element={
              <ProtectedRoute adminOnly>
                <AdminReservationsPage />
              </ProtectedRoute>
            } />
        </Routes>

      </main>
    </>
  )

}

export default App