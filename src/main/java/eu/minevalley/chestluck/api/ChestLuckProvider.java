package eu.minevalley.chestluck.api;

import eu.minevalley.chestluck.api.core.locking.Lockable;
import eu.minevalley.proxima.api.Registrant;
import org.bukkit.block.Block;
import org.jetbrains.annotations.ApiStatus;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@ApiStatus.Internal
public interface ChestLuckProvider {

    @Nonnull
    Lockable<? extends Lockable<?>> createLockable(Registrant owner, Block block, Registrant... registrants) throws IllegalArgumentException;

    @Nullable
    Lockable<? extends Lockable<?>> getLockableAt(Block block) throws IllegalArgumentException;
}