package eu.minevalley.chestluck.api.core.logging;

import eu.minevalley.proxima.api.user.User;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;

import javax.annotation.Nonnull;
import java.time.Instant;

@SuppressWarnings("unused")
@Getter
public final class LogQuery<T extends LogEntry> {

    private final Class<T> type;
    private User user;
    private Location location;
    private Instant from, to;
    private int limit = 100;

    private LogQuery(Class<T> type) {
        this.type = type;
    }

    /**
     * Query for a specific log type. Use {@code LogEntry.class} for all types.
     */
    @Nonnull
    public static <T extends LogEntry> LogQuery<T> of(@Nonnull Class<T> type) {
        return new LogQuery<>(type);
    }

    @Nonnull
    @Contract("_ -> this")
    public LogQuery<T> user(@Nonnull User user) {
        this.user = user;
        return this;
    }

    @Nonnull
    @Contract("_ -> this")
    public LogQuery<T> at(@Nonnull Block block) {
        this.location = block.getLocation();
        return this;
    }

    @Nonnull
    @Contract("_ -> this")
    public LogQuery<T> since(@Nonnull Instant from) {
        this.from = from;
        return this;
    }

    @Nonnull
    @Contract("_ -> this")
    public LogQuery<T> until(@Nonnull Instant to) {
        this.to = to;
        return this;
    }

    @Nonnull
    @Contract("_ -> this")
    public LogQuery<T> limit(int limit) {
        this.limit = limit;
        return this;
    }
}