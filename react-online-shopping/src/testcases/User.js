import { useState } from "react"

function TestUser()
{
    const [userName,setuserName] = useState("")
    const [userId,setuserId] = useState("")
    const [password,setpassword] = useState("")
    const [uFirstName, setuFirstName] = useState("")
    const [uLastName, setuLastName] = useState("")
    const [userAddress, setuserAddress] = useState("")
    const [phone, setphone] = useState()

    return <div> Welcome To User Entity!!!
    <button onClick={()=>{
        setuserName("naren")
    }}> View User Name </button>
    {userName}

    <button onClick={()=>{
        setuserId("11")
    }}> View User Id </button>
    {userId}

    <button onClick={()=>{
        setpassword("naren123")
    }}> View User Password </button>
    {password}

    <button onClick={()=>{
        setuserAddress("KTM")
    }}> View User Address </button>
    {userAddress}

    <button onClick={()=>{
        setuFirstName("Naren")
    }}> View User First Name </button>
    {uLastName}

    <button onClick={()=>{
        setuLastName("Raval")
    }}> View User Last Name </button>
    {uLastName}

    <button onClick={()=>{
        setphone(987654321)
    }}> View User Phone </button>
    {phone}

    </div>
}
export default TestUser;
