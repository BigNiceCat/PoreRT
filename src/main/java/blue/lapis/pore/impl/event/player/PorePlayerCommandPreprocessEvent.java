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
package blue.lapis.pore.impl.event.player;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.spongepowered.api.event.message.CommandEvent;

import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

public class PorePlayerCommandPreprocessEvent extends PlayerCommandPreprocessEvent {

    private final CommandEvent handle;

    public PorePlayerCommandPreprocessEvent(CommandEvent handle) {
        super(null, null, null);
        this.handle = checkNotNull(handle, "handle");
    }

    public CommandEvent getHandle() {
        return handle;
    }

    @Override
    public Player getPlayer() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setPlayer(Player player) throws IllegalArgumentException {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public String getMessage() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setMessage(String command) throws IllegalArgumentException {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public String getFormat() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setFormat(String format) {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public Set<Player> getRecipients() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public boolean isCancelled() {
        throw new NotImplementedException(); // TODO
    }

    @Override
    public void setCancelled(boolean cancel) {
        throw new NotImplementedException(); // TODO
    }

}
