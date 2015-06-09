/*
 * Pore
 * Copyright (c) 2014-2015, Lapis <https://github.com/LapisBlue>
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package blue.lapis.pore.converter.data;

import com.google.common.base.Converter;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.NotImplementedException;
import org.spongepowered.api.data.manipulator.SingleValueData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class DataTypeConverter {

    @SuppressWarnings("rawtypes")
    protected final LinkedHashMap<Converter<AbstractDataValue, Byte>, Byte> converters
            = new LinkedHashMap<Converter<AbstractDataValue, Byte>, Byte>();

    protected final ArrayList<Class<? extends SingleValueData<?, ?>>> applicableTypes = Lists.newArrayList();

    public Collection<Class<? extends SingleValueData<?, ?>>> getApplicableDataTypes() {
        return applicableTypes;
    }

    public byte of(Collection<SingleValueData<?, ?>> data) {
        throw new NotImplementedException("TODO");
    }

    @SuppressWarnings("rawtypes") // I am very tired and do not feel like dealing with generics anymore
    public Collection<AbstractDataValue> of(byte data) {
        ArrayList<AbstractDataValue> converted = new ArrayList<AbstractDataValue>();
        int i = 0;
        for (Map.Entry<Converter<AbstractDataValue, Byte>, Byte> e : converters.entrySet()) {
            Converter<AbstractDataValue, Byte> c = e.getKey();
            int bitsToConsider = e.getValue(); // the number of bits to consider from the data byte
            assert bitsToConsider <= 8; // we can't consider more than 8 bits within a single byte
            byte masked = data;
            masked >>= i; // right-shift to discard bits considered in previous iterations
            byte mask = (byte)(Math.pow(2, bitsToConsider) - 1); // calculate the bitmask based on the size
            masked |= mask; // apply the mask
            converted.add(c.reverse().convert(masked));
            i += bitsToConsider; // increment the offset for future iterations
        }
        return converted;
    }

}
