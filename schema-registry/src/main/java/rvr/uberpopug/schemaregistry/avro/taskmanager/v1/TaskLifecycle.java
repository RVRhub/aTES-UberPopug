/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package rvr.uberpopug.schemaregistry.avro.taskmanager.v1;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class TaskLifecycle extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1292499689008768823L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TaskLifecycle\",\"namespace\":\"rvr.uberpopug.schemaregistry.avro.taskmanager.v1\",\"fields\":[{\"name\":\"publicId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"account_public_id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"},\"avro.java.string\":\"String\"},{\"name\":\"event_id\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null},{\"name\":\"event_version\",\"type\":[\"int\"],\"default\":1},{\"name\":\"event_name\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":1},{\"name\":\"event_time\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TaskLifecycle> ENCODER =
      new BinaryMessageEncoder<TaskLifecycle>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TaskLifecycle> DECODER =
      new BinaryMessageDecoder<TaskLifecycle>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<TaskLifecycle> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<TaskLifecycle> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TaskLifecycle>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this TaskLifecycle to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a TaskLifecycle from a ByteBuffer. */
  public static TaskLifecycle fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String publicId;
  @Deprecated public java.lang.String account_public_id;
  @Deprecated public java.lang.String event_id;
  @Deprecated public java.lang.Object event_version;
  @Deprecated public java.lang.String event_name;
  @Deprecated public java.lang.String event_time;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TaskLifecycle() {}

  /**
   * All-args constructor.
   * @param publicId The new value for publicId
   * @param account_public_id The new value for account_public_id
   * @param event_id The new value for event_id
   * @param event_version The new value for event_version
   * @param event_name The new value for event_name
   * @param event_time The new value for event_time
   */
  public TaskLifecycle(java.lang.String publicId, java.lang.String account_public_id, java.lang.String event_id, java.lang.Object event_version, java.lang.String event_name, java.lang.String event_time) {
    this.publicId = publicId;
    this.account_public_id = account_public_id;
    this.event_id = event_id;
    this.event_version = event_version;
    this.event_name = event_name;
    this.event_time = event_time;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return publicId;
    case 1: return account_public_id;
    case 2: return event_id;
    case 3: return event_version;
    case 4: return event_name;
    case 5: return event_time;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: publicId = (java.lang.String)value$; break;
    case 1: account_public_id = (java.lang.String)value$; break;
    case 2: event_id = (java.lang.String)value$; break;
    case 3: event_version = (java.lang.Object)value$; break;
    case 4: event_name = (java.lang.String)value$; break;
    case 5: event_time = (java.lang.String)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'publicId' field.
   * @return The value of the 'publicId' field.
   */
  public java.lang.String getPublicId() {
    return publicId;
  }

  /**
   * Sets the value of the 'publicId' field.
   * @param value the value to set.
   */
  public void setPublicId(java.lang.String value) {
    this.publicId = value;
  }

  /**
   * Gets the value of the 'account_public_id' field.
   * @return The value of the 'account_public_id' field.
   */
  public java.lang.String getAccountPublicId() {
    return account_public_id;
  }

  /**
   * Sets the value of the 'account_public_id' field.
   * @param value the value to set.
   */
  public void setAccountPublicId(java.lang.String value) {
    this.account_public_id = value;
  }

  /**
   * Gets the value of the 'event_id' field.
   * @return The value of the 'event_id' field.
   */
  public java.lang.String getEventId() {
    return event_id;
  }

  /**
   * Sets the value of the 'event_id' field.
   * @param value the value to set.
   */
  public void setEventId(java.lang.String value) {
    this.event_id = value;
  }

  /**
   * Gets the value of the 'event_version' field.
   * @return The value of the 'event_version' field.
   */
  public java.lang.Object getEventVersion() {
    return event_version;
  }

  /**
   * Sets the value of the 'event_version' field.
   * @param value the value to set.
   */
  public void setEventVersion(java.lang.Object value) {
    this.event_version = value;
  }

  /**
   * Gets the value of the 'event_name' field.
   * @return The value of the 'event_name' field.
   */
  public java.lang.String getEventName() {
    return event_name;
  }

  /**
   * Sets the value of the 'event_name' field.
   * @param value the value to set.
   */
  public void setEventName(java.lang.String value) {
    this.event_name = value;
  }

  /**
   * Gets the value of the 'event_time' field.
   * @return The value of the 'event_time' field.
   */
  public java.lang.String getEventTime() {
    return event_time;
  }

  /**
   * Sets the value of the 'event_time' field.
   * @param value the value to set.
   */
  public void setEventTime(java.lang.String value) {
    this.event_time = value;
  }

  /**
   * Creates a new TaskLifecycle RecordBuilder.
   * @return A new TaskLifecycle RecordBuilder
   */
  public static rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder newBuilder() {
    return new rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder();
  }

  /**
   * Creates a new TaskLifecycle RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TaskLifecycle RecordBuilder
   */
  public static rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder newBuilder(rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder other) {
    return new rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder(other);
  }

  /**
   * Creates a new TaskLifecycle RecordBuilder by copying an existing TaskLifecycle instance.
   * @param other The existing instance to copy.
   * @return A new TaskLifecycle RecordBuilder
   */
  public static rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder newBuilder(rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle other) {
    return new rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder(other);
  }

  /**
   * RecordBuilder for TaskLifecycle instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TaskLifecycle>
    implements org.apache.avro.data.RecordBuilder<TaskLifecycle> {

    private java.lang.String publicId;
    private java.lang.String account_public_id;
    private java.lang.String event_id;
    private java.lang.Object event_version;
    private java.lang.String event_name;
    private java.lang.String event_time;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.publicId)) {
        this.publicId = data().deepCopy(fields()[0].schema(), other.publicId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.account_public_id)) {
        this.account_public_id = data().deepCopy(fields()[1].schema(), other.account_public_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.event_id)) {
        this.event_id = data().deepCopy(fields()[2].schema(), other.event_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.event_version)) {
        this.event_version = data().deepCopy(fields()[3].schema(), other.event_version);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.event_name)) {
        this.event_name = data().deepCopy(fields()[4].schema(), other.event_name);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.event_time)) {
        this.event_time = data().deepCopy(fields()[5].schema(), other.event_time);
        fieldSetFlags()[5] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing TaskLifecycle instance
     * @param other The existing instance to copy.
     */
    private Builder(rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.publicId)) {
        this.publicId = data().deepCopy(fields()[0].schema(), other.publicId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.account_public_id)) {
        this.account_public_id = data().deepCopy(fields()[1].schema(), other.account_public_id);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.event_id)) {
        this.event_id = data().deepCopy(fields()[2].schema(), other.event_id);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.event_version)) {
        this.event_version = data().deepCopy(fields()[3].schema(), other.event_version);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.event_name)) {
        this.event_name = data().deepCopy(fields()[4].schema(), other.event_name);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.event_time)) {
        this.event_time = data().deepCopy(fields()[5].schema(), other.event_time);
        fieldSetFlags()[5] = true;
      }
    }

    /**
      * Gets the value of the 'publicId' field.
      * @return The value.
      */
    public java.lang.String getPublicId() {
      return publicId;
    }

    /**
      * Sets the value of the 'publicId' field.
      * @param value The value of 'publicId'.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder setPublicId(java.lang.String value) {
      validate(fields()[0], value);
      this.publicId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'publicId' field has been set.
      * @return True if the 'publicId' field has been set, false otherwise.
      */
    public boolean hasPublicId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'publicId' field.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder clearPublicId() {
      publicId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'account_public_id' field.
      * @return The value.
      */
    public java.lang.String getAccountPublicId() {
      return account_public_id;
    }

    /**
      * Sets the value of the 'account_public_id' field.
      * @param value The value of 'account_public_id'.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder setAccountPublicId(java.lang.String value) {
      validate(fields()[1], value);
      this.account_public_id = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'account_public_id' field has been set.
      * @return True if the 'account_public_id' field has been set, false otherwise.
      */
    public boolean hasAccountPublicId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'account_public_id' field.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder clearAccountPublicId() {
      account_public_id = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'event_id' field.
      * @return The value.
      */
    public java.lang.String getEventId() {
      return event_id;
    }

    /**
      * Sets the value of the 'event_id' field.
      * @param value The value of 'event_id'.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder setEventId(java.lang.String value) {
      validate(fields()[2], value);
      this.event_id = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'event_id' field has been set.
      * @return True if the 'event_id' field has been set, false otherwise.
      */
    public boolean hasEventId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'event_id' field.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder clearEventId() {
      event_id = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'event_version' field.
      * @return The value.
      */
    public java.lang.Object getEventVersion() {
      return event_version;
    }

    /**
      * Sets the value of the 'event_version' field.
      * @param value The value of 'event_version'.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder setEventVersion(java.lang.Object value) {
      validate(fields()[3], value);
      this.event_version = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'event_version' field has been set.
      * @return True if the 'event_version' field has been set, false otherwise.
      */
    public boolean hasEventVersion() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'event_version' field.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder clearEventVersion() {
      event_version = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'event_name' field.
      * @return The value.
      */
    public java.lang.String getEventName() {
      return event_name;
    }

    /**
      * Sets the value of the 'event_name' field.
      * @param value The value of 'event_name'.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder setEventName(java.lang.String value) {
      validate(fields()[4], value);
      this.event_name = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'event_name' field has been set.
      * @return True if the 'event_name' field has been set, false otherwise.
      */
    public boolean hasEventName() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'event_name' field.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder clearEventName() {
      event_name = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'event_time' field.
      * @return The value.
      */
    public java.lang.String getEventTime() {
      return event_time;
    }

    /**
      * Sets the value of the 'event_time' field.
      * @param value The value of 'event_time'.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder setEventTime(java.lang.String value) {
      validate(fields()[5], value);
      this.event_time = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'event_time' field has been set.
      * @return True if the 'event_time' field has been set, false otherwise.
      */
    public boolean hasEventTime() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'event_time' field.
      * @return This builder.
      */
    public rvr.uberpopug.schemaregistry.avro.taskmanager.v1.TaskLifecycle.Builder clearEventTime() {
      event_time = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TaskLifecycle build() {
      try {
        TaskLifecycle record = new TaskLifecycle();
        record.publicId = fieldSetFlags()[0] ? this.publicId : (java.lang.String) defaultValue(fields()[0]);
        record.account_public_id = fieldSetFlags()[1] ? this.account_public_id : (java.lang.String) defaultValue(fields()[1]);
        record.event_id = fieldSetFlags()[2] ? this.event_id : (java.lang.String) defaultValue(fields()[2]);
        record.event_version = fieldSetFlags()[3] ? this.event_version : (java.lang.Object) defaultValue(fields()[3]);
        record.event_name = fieldSetFlags()[4] ? this.event_name : (java.lang.String) defaultValue(fields()[4]);
        record.event_time = fieldSetFlags()[5] ? this.event_time : (java.lang.String) defaultValue(fields()[5]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TaskLifecycle>
    WRITER$ = (org.apache.avro.io.DatumWriter<TaskLifecycle>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TaskLifecycle>
    READER$ = (org.apache.avro.io.DatumReader<TaskLifecycle>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
