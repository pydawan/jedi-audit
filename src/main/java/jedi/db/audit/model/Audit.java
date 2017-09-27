package jedi.db.audit.model;

import java.util.Date;

import jedi.db.models.CharField;
import jedi.db.models.DateTimeField;
import jedi.db.models.Manager;
import jedi.db.models.Model;
import jedi.db.models.TextField;

/**
 * <p>
 * Cria registros de auditoria em um banco de dados relacional.
 * </p>
 * 
 * @author thiago-amm
 * @version v1.0.0 26/09/2017
 * @since v1.0.0
 */
public class Audit<T extends Model> extends Model {
   
   private static final long serialVersionUID = 1L;
   
   @CharField(max_length = 50)
   protected String event;
   
   @TextField
   protected String object;
   
   @CharField(max_length = 255)
   protected String author;
   
   @DateTimeField(auto_now_add = true, auto_now = true)
   protected Date date;
   
   public static Manager objects = new Manager(Audit.class);
   
   public Audit(T object, AuditEvent event, String author) throws IllegalArgumentException {
      setObject(object);
      setEvent(event);
      setAuthor(author);
   }
   
   public Audit(T object, String author) {
      this(object, AuditEvent.SAVE, author);
   }
   
   public String getEvent() {
      return event;
   }
   
   public void setEvent(String event) {
      event = event == null ? "" : event;
      if (event.isEmpty()) {
         throw new IllegalArgumentException("ATENÇÃO: o evento da auditoria não pode ser nulo ou vazio!");
      } else {
         this.event = event;
      }
   }
   
   public void setEvent(AuditEvent event) {
      if (event == null) {
         throw new IllegalArgumentException("ATENÇÃO: o evento da auditoria não pode ser nulo!");
      } else {
         this.event = event.getValue();
      }
   }
   
   public String event() {
      return getEvent();
   }
   
   public Audit<T> event(String event) {
      setEvent(event);
      return this;
   }
   
   public Audit<T> event(AuditEvent event) {
      setEvent(event);
      return this;
   }
   
   public String getObject() {
      return object;
   }
   
   public void setObject(String object) {
      this.object = object;
   }
   
   public void setObject(T object) {
      this.object = object == null ? "" : object.toString();
   }
   
   public String object() {
      return getObject();
   }
   
   public Audit<T> object(String object) {
      setObject(object);
      return this;
   }
   
   public Audit<T> object(T object) {
      setObject(object);
      return this;
   }
   
   public String getAuthor() {
      return author;
   }
   
   public void setAuthor(String author) {
      this.author = author;
   }
   
   public String author() {
      return getAuthor();
   }
   
   public Audit<T> author(String author) {
      this.author = author;
      return this;
   }
   
   public Date getDate() {
      return date;
   }
   
   public void setDate(Date date) {
      this.date = date;
   }
   
   public Date date() {
      return getDate();
   }
   
   public Audit<T> date(Date date) {
      setDate(date);
      return this;
   }
   
}
