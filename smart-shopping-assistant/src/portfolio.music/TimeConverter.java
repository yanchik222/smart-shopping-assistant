package portfolio.music;

import java.util.concurrent.TimeUnit;

/**
 * Utility class for converting seconds or nanoseconds into formatted time strings.
 *
 * Author: Yana Loviagina
 */
public class TimeConverter 
{
	/**
	 * class method that converts seconds into format:
	 * hours : minutes : seconds
	 */
	public static String convertTimeToString(int time) 
{
    	int hours = time / 3600;
    	int minutes = (time % 3600) / 60;
    	int seconds = time % 60;

    return hours + ":" + minutes + ":" + seconds;
}

	/**
	 * class method that converts nano-seconds into format:
	 * hours : minutes : seconds : milli-seconds : nano-seconds
	 */
	public static String convertTimeToString(long nanos) 
	{
		if(nanos < 0)
		{
			throw new IllegalArgumentException("ERROR : Duration is less than zero!");
		}


		long hours = TimeUnit.NANOSECONDS.toHours(nanos);
		nanos -= TimeUnit.HOURS.toNanos(hours);
		long minutes = TimeUnit.NANOSECONDS.toMinutes(nanos);
		nanos -= TimeUnit.MINUTES.toNanos(minutes);
		long seconds = TimeUnit.NANOSECONDS.toSeconds(nanos);
		nanos -= TimeUnit.SECONDS.toNanos(seconds);
		long milliseconds = TimeUnit.NANOSECONDS.toMillis(nanos);
		nanos -= TimeUnit.MILLISECONDS.toNanos(milliseconds);

		StringBuilder sb = new StringBuilder(64);
		sb.append(hours);
		sb.append(" hrs : ");
		sb.append(minutes);
		sb.append(" mins : ");
		sb.append(seconds);
		sb.append(" sec : ");
		sb.append(milliseconds);
		sb.append(" ms : ");
		sb.append(nanos);
		sb.append(" ns");

		return(sb.toString());
	}
}
