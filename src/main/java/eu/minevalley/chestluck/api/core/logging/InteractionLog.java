package eu.minevalley.chestluck.api.core.logging;

import eu.minevalley.proxima.api.user.User;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;

@SuppressWarnings("unused")
public record InteractionLog(
        @Nonnull Block block, @Nullable User user, @Nonnull String description, @Nonnull Instant timestamp,
        @Nonnull Interaction interaction) implements LogEntry {

    public enum Interaction {OPEN, CLOSE, LOCK, UNLOCK, GRANT_PERMISSION, REVOKE_PERMISSION}
}