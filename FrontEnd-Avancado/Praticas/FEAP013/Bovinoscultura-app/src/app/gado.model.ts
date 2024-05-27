export interface Gado{
  id: string;
  anilhaAnimal: number;
  anilhaPai: number;
  anilhaMae: number;
  dataNascimento: Date;
  dataSaida: Date;
  status: string;
  sexo: string;
  pesos: Peso[]; 
  vacinacaoRaiva: Date; // Vacinação Raiva
  vacinacaoRiniteAtrofica: Date; // Vacinação Rinite Atrófica
  banho: Date; // Data do banho
  observacao?: string; // Observação
}

export interface Peso {
  dataPesagem: Date;
  pesoKg: number;
}

export class Gado {
}
