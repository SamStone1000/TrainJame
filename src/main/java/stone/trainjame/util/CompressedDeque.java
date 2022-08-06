/**
 * This file is part of TrainJame. 
 * Copyright (c) 2022, Stone, All rights reserved.
 * 
 * TrainJame is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * TrainJame is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with TrainJame. If not, see <https://www.gnu.org/licenses/>.
 */
package stone.trainjame.util;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/**
 * @param <E>
 * 
 */
public class CompressedDeque<E> implements Deque<E> {

	Deque<Entry<E>> delegate;

	public CompressedDeque(Deque<Entry<E>> delegate) {
		this.delegate = delegate;
	}

	@Override
	public boolean add(E e) {
		addLast(e);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addFirst(E e) {
		Entry<E> current = delegate.peekFirst();
		if (current == null)
			delegate.addFirst(new Entry<>(e));
		else if (!current.offer(e))
				delegate.addFirst(new Entry<>(e));
	}

	@Override
	public void addLast(E e) {
		Entry<E> current = delegate.peekLast();
		if (current == null)
			delegate.addLast(new Entry<>(e));
		else if (!current.offer(e))
				delegate.addLast(new Entry<>(e));
	}

	@Override
	public void clear() {
		delegate.clear();
	}

	@Override
	public boolean contains(Object o) {
		unsupported();
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		unsupported();
		return false;
	}

	@Override
	public Iterator<E> descendingIterator() {
		unsupported();
		return null;
	}

	@Override
	public E element() {
		return delegate.peek().getType();
	}

	@Override
	public E getFirst() {
		return delegate.getFirst().getType();
	}

	@Override
	public E getLast() {
		return delegate.getLast().getType();
	}

	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		unsupported();
		return null;
	}

	@Override
	public boolean offer(E e) {
		Entry<E> current = delegate.peekLast();
		if (current == null)
			return delegate.offer(new Entry<>(e));
		else
		if (current.offer(e))
			return true;
		else
			return delegate.offer(new Entry<>(e));

	}

	@Override
	public boolean offerFirst(E e) {
		Entry<E> current = delegate.peekFirst();
		if (current == null)
			return delegate.offerFirst(new Entry<>(e));
		else
		if (current.offer(e))
			return true;
		else
			return delegate.offerFirst(new Entry<>(e));
	}

	@Override
	public boolean offerLast(E e) {
		Entry<E> current = delegate.peekLast();
		if (current == null)
			return delegate.offerLast(new Entry<>(e));
		else if (current.offer(e))
			return true;
		else
			return delegate.offerLast(new Entry<>(e));
	}

	@Override
	public E peek() {
		return peekFirst();
	}

	@Override
	public E peekFirst() {
		Entry<E> e = delegate.peekFirst();
		if (e == null)
			return null;
		else
			return e.getType();
	}

	@Override
	public E peekLast() {
		Entry<E> e = delegate.peekLast();
		if (e == null)
			return null;
		else
			return e.getType();
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pollFirst() {
		Entry<E> e = delegate.peekFirst();
		if (e == null)
			return null;
		else
			return e.remove();

	}

	@Override
	public E pollLast() {
		Entry<E> e = delegate.peekLast();
		if (e == null)
			return null;
		else
			return e.remove();
	}

	@Override
	public E pop() {
		return removeFirst();
	}

	@Override
	public void push(E e) {
		addFirst(e);
	}

	@Override
	public E remove() {
		return removeFirst();
	}

	@Override
	public boolean remove(Object o) {
		unsupported();
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		unsupported();
		return false;
	}

	@Override
	public E removeFirst() {
		return delegate.peekFirst().remove();
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		unsupported();
		return false;
	}

	@Override
	public E removeLast() {
		return delegate.peekLast().remove();
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		unsupported();
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		unsupported();
		return false;
	}

	@Override
	public int size() {
		int count = 0;
		for (Entry e : delegate)
		{
			count += e.getCount();
		}
		return count;
	}

	@Override
	public Object[] toArray() {
		unsupported();
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		unsupported();
		return null;
	}

	private void unsupported() {
		throw new UnsupportedOperationException("The attempted operation is unsupported");
	}

	private class Entry<T> {
		private T type;
		private int count;

		/**
		 * Creates a new entry with a count of 1 and the supplied type, the given object
		 * is used as backing for this entry's type
		 * 
		 * @param type the type of object this entry is representing
		 */
		public Entry(T type) {
			this.type = type;
			this.count = 1;
		}

		/**
		 * @return
		 */
		public int getCount() {
			return count;
		}

		public T getType() {
			return type;
		}

		/**
		 * offers the given element to be added to this entry, returns true of the
		 * element was successfully added
		 * 
		 * @param element the element to add to this entry
		 * @return true if the element was added, false otherwise
		 */
		public boolean offer(T element) {
			if (type.equals(element))
			{
				count++;
				return true;
			} else
				return false;
		}

		public T remove() {
			this.count--;
			if (count <= 0)
			{
				delegate.remove(this);
			}
			return type;
		}
	}

}
