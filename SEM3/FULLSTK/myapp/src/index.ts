const express=require('express');
const app=express(); 
const port =3000;

app.use(express.json());

let books=[
  {id:1, title:'Lord of the rings', author:'JK Tokein', price:23.98,quantity:12},
  {id:2, title:'Harry potter', author:'JK rowlings', price:2.98,quantity:10},
  {id:3, title:'To Kill a Mocking Bird', author:'Harper Lee', price:2.8,quantity:16}
];


app.get('/book', (req,res)=>{
  return res.status(200).json(books);
});


app.get('/book:/id', (req,res)=>{
  const book =books.find((b)=>b.id===parseInt(req.params.id));
  console.log(typeof(req.params.id), " ",books);
  if(book){
    return res.status(200).json(books);
  }else{
    return res.status(201).send("book not found");
  }
});
