const { Client } = require('pg')
const express = require('express')
const cors = require('cors')


const app = express()

app.listen(3069)
app.use(express.json())
app.use(cors())

const connectionString = 'postgresql://postgres:password@localhost:5432/logindb'

const client = new Client({connectionString})
client.connect()

app.post('/login',async(req,res)=>{
    console.log(req.body)
    const {uname,pass} = req.body;
    const query = `select password from users where username like '${uname}'`
    const result = (await client.query(query)).rows;
    if(result.length == 0) res.sendStatus(401);
    
    const dbpass = result[0].password;
        if(pass != dbpass) res.status(401);
    res.send();
})
app.post('/signup',(req,res)=>{
    const {uname,pass,email} = req.body;
    console.log(req.body)
    const query = `insert into users values('${uname}','${pass}','${email}')`
    client.query(query);
    res.send("Success");
})