package bugsbusters.lucatickets.pagos.controller.error;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomErrorJson {


	private String timestamp;
		private int status;
		private String error;
		private String trace;
		private List<String> message;
		private String path;

		
		public CustomErrorJson(Date timestamp, int status, String error, String trace, List<String> message, String path,
				String jdk) {
			super();
			// Formato DD/MM/YY HH:MM:ss
			this.timestamp = this.changeTimeStamp(timestamp);
			this.status = status;
			this.error = error;
			this.trace = trace;
			this.message = message;
			this.path = path;
		
		}

		public void setTimestamp(Date timestamp) {
			this.timestamp = this.changeTimeStamp(timestamp);
		}	



		private String changeTimeStamp(Date d) {
			// Formato España
			final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

			// format & update timestamp
			return dateFormat.format(d);
		}

}
