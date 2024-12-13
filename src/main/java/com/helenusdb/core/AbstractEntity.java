/*
    Copyright 2017-2022, Strategic Gains, Inc.

	Licensed under the Apache License, Version 2.0 (the "License");
	you may not use this file except in compliance with the License.
	You may obtain a copy of the License at

		http://www.apache.org/licenses/LICENSE-2.0

	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/
package com.helenusdb.core;

/**
 * An entity (has an {@link Identifier}) as well as a single Object ID ('id'
 * property). This can be used as a base class for entities that have a single
 * unique identifier property.
 * 
 * The {@link #getIdentifier()} method is implemented to return the ID as the
 * single component of the Identifier. Subclasses may override this method to
 * provide an alternate Identifier that reflects an alternate key or composite 
 * key.
 * 
 * @param <T> the type of the object ID property.
 * @author Todd Fredrich
 * @since Oct 6, 2017
 */
public abstract class AbstractEntity<T>
implements Entity<T>
{
	/**
	 * The object ID for this Entity.
	 */
	private T id;

	/**
	 * Default constructor.
	 */
	AbstractEntity()
	{
		super();
	}

	/**
	 * Constructor.
	 * 
	 * @param objectId the object ID for this Entity.
	 */
	AbstractEntity(T objectId)
	{
		this();
		setId(objectId);
	}

	/**
	 * The default implementation returns the Object ID ('id' property) as the
	 * single component of the Identifier.
	 */
	@Override
	public Identifier getIdentifier()
	{
		return (id == null ? null : new Identifier(id));
	}

	/**
	 * Answer the object ID for this Entity.
	 * 
	 * @return the entity's object ID.
	 */
	public T getId()
	{
		return id;
	}

	/**
	 * Answers whether the object ID for this Entity is populated.
	 * 
	 * @return true if the entity's ID property is non-null. Otherwise, false.
	 */
	public boolean hasId()
	{
		return (id != null);
	}

	/**
	 * Set the object ID for this Entity.
	 * 
	 * @param objectId the new object ID.
	 */
	public void setId(T objectId)
	{
		this.id = objectId;
	}
}
