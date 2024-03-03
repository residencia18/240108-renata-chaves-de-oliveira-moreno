const express = require('express');
const mongoose = require('mongoose');
const bodyParser = require('body-parser');


const app = express();
const PORT = 3000;

// Conexão com o MongoDB
mongoose.connect('mongodb://localhost:27017/petshop', {
  useNewUrlParser: true,
  useUnifiedTopology: true
}).then(() => {
  console.log('Conectado ao MongoDB');
}).catch((error) => {
  console.error('Erro ao conectar ao MongoDB:', error);
});

// Model para Atendimento
const Atendimento = mongoose.model('Atendimento', {
  nomePet: String,
  tipoPet: String,
  dataAtendimento: Date,
  observacoes: String
});

// Middleware para parsing de JSON
app.use(bodyParser.json());

// Use o middleware CORS
const cors = require('cors');
app.use(cors());

// Rota para cadastrar atendimento
app.post('/api/atendimentos', async (req, res) => {
  try {
    const atendimento = new Atendimento(req.body);
    await atendimento.save();
    res.status(201).send(atendimento);
  } catch (error) {
    res.status(400).send(error);
  }
});

// Rota para listar todos os atendimentos
app.get('/api/atendimentos', async (req, res) => {
  try {
    const atendimentos = await Atendimento.find();
    res.send(atendimentos);
  } catch (error) {
    res.status(500).send(error);
  }
});

app.listen(PORT, () => {
  console.log(`Servidor está ouvindo na porta ${PORT}`);
});
