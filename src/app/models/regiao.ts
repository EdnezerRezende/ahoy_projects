import {Compra} from "./children/compra";
import {PrecoMedio} from "./children/preco-medio";
import {Geracao} from "./children/geracao";

export class Regiao {
  sigla?: string;
  geracao?: Geracao[];
  compra?: Compra[];
  precoMedio?: PrecoMedio[];

  constructor() {
  }

}
