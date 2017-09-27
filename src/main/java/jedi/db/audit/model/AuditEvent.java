package jedi.db.audit.model;

/**
 * @author thiago-amm
 * @version v1.0.0 26/09/2017
 * @since v1.0.0
 */
public enum AuditEvent {
   
   LIST("Listar", "LISTAR"),
   SEARCH("Pesquisar", "PESQUISAR"),
   ADD("Adicionar", "ADICIONAR"),
   EDIT("Editar", "EDITAR"),
   REMOVE("Remover", "REMOVER"),
   SAVE("Salvar", "SALVAR"),
   CANCEL("Cancelar", "CANCELAR"),
   LIMPAR("Limpar", "LIMPAR");
   
   private final String label;
   private final String value;
   
   private AuditEvent(String label, String value) {
      this.label = label;
      this.value = value;
   }
   
   public String getLabel() {
      return label;
   }
   
   public String getValue() {
      return value;
   }
   
   public String label() {
      return getLabel();
   }
   
   public String value() {
      return getValue();
   }
   
}
