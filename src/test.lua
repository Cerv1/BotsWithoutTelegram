get_contact_list ()

local function callback(extra, success, result)
  if success then
    print('File downloaded to:', result)
  else
    print('Error downloading: '..extra)
  end
end

function on_msg_receive (msg)
      if (msg.from.first_name == "ImageBot") then
          load_photo(msg.id, callback, msg.id)
      end
  end
